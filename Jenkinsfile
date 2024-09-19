pipeline {
    agent any  // Define where to run the pipeline

    stages {
        stage('Building jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Building image') {
            steps {
                bat "docker build -t attbatch1/buildimagethroughjenkins ."
            }
        }

        stage('Push Image') {
            steps {
                bat "docker push attbatch1/buildimagethroughjenkins"
            }
        }
    }
}
