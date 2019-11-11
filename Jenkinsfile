pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile.build'
            dir '.'
            label 'Docker KNX MockServer build'
            args '-v /tmp:/tmp'
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