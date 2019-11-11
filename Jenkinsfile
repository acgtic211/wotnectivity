pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile.build'
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'su -'
                sh '/usr/app/calimero-testnetwork/gradle run'
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