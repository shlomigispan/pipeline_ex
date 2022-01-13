pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                echo "building the app..."
            }
        }
        stage("test") {
            
            steps {
                echo "testing the app..."
            }
        }
        stage("deploy") {
            
            steps {
                echo "deploying the app..."

            }
        }
    }
    post {
        always {
            echo "pass"
        }
        success {
            echo "pass"
        }
        failure {
            echo "pass"
        }
    }
}