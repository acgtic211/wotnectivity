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
                sh 'mvn -B -Dtest=!KnxReqTest* clean package' 
                // mvn -B -DskipTests clean package
                jacoco( 
                    execPattern: 'target/Http*.exec',
                    classPattern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    exclusionPattern: 'src/test*'
                )
            }
        }
    }
}