pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile.build'
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'cd /usr/app/calimero-testnetwork'
                sh 'gradle run'
                sh 'cd /var/jenkins_home/workspace/wotnectivity'
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