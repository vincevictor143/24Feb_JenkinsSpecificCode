#!/bin/bash

# Print HUB_HOST value
echo "--------------------------------"
echo "HUB_HOST      : $HUB_HOST"
echo "--------------------------------"

# Ensure HUB_HOST is set
if [ -z "$HUB_HOST" ]; then
  echo "HUB_HOST is not set. Exiting!"
  exit 1
fi

# Wait for Selenium Grid Hub to be ready
echo "Checking if hub is ready...!"
count=0
while [ "$(curl -s http://$HUB_HOST:4444/status | jq -r .value.ready)" != "true" ]; do
  count=$((count + 1))
  echo "Attempt: ${count}"
  
  # Timeout after 60 attempts
  if [ "$count" -ge 60 ]; then
    echo "****** HUB IS NOT READY WITHIN 60 SECONDS ******"
    exit 1
  fi
  
  sleep 1
done

# Selenium Grid is ready
echo "Selenium Grid is up and running. Running the tests..."

# Run the test using Java
java -DHUB_HOST="$HUB_HOST" -cp "libs/*" org.testng.TestNG testng1.xml
