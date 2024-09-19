# Let's print what we have received 
echo "--------------------------------"
echo "HUB_HOST      : $HUB_HOST"
echo "--------------------------------"

# Do not start the tests immediately. Hub has to be ready with browser nodes 
echo "Checking if hub is ready..!"
count=0
while [ "$( curl -s http://$HUB_HOST:4444/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 60 ]
  then
    echo "****** HUB IS NOT READY WITHIN 60 SECONDS ******"
    exit 1
  fi
  sleep 1
done

# At this point, selenium grid should be up !
echo "Selenium Grid is up and running. Running the test...."

# Start the java command 
java  -DHUB_HOST=$HUB_HOST -cp "libs/*" org.testng.TestNG testng1.xml