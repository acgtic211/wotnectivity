pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile.build'
            args 'gradle run'
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B clean package' 
                // mvn -B -DskipTests clean package
                jacoco( 
                    execPattern: 'target/*.exec',
                    classPattern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    exclusionPattern: 'src/test*'
                )
            }
        }

    }
}