pipeline {
    agent {
        docker {
            image 'maven:3.6-jdk-11-openj9' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}