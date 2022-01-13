pipeline {

    agent any

    stages {

        stage("build") {
            when { // דוגמה לתנאי בוליאני: כלומר רק אם <הביטוי באקספרשן הוא אמת> יקרה <מה שנמצא בסטאג'> י
                expression { // היטוי הבוליאני שצריך להתקיים כדי שהסטאג' יתבצע

                }
            }
                
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
    post { // כאן נגדיר מה קורה בסיום הפעולה
        always { // תמיד לא משנה אם הצליח או לא
            echo "pass"
        }
        success { // פעולות שיקרו רק אם הגוב הצליח
            echo "pass"
        }
        failure { // פעולות שיקרו רק אם הגוב נכשל
            echo "pass"
        }
    }
}