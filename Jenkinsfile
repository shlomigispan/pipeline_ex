// כאן נגדיר את המשתנים הלא מובנים מראש. נצטרך לקשר אותם לסקריפטים בשפת גרובי ששם נכתוב את הפעולות
CODE_CHANGES == getGitChanges() 
pipeline {

    agent any

    stages {

        stage("build") {
            when { // דוגמה לתנאי בוליאני: כלומר רק אם <הביטוי באקספרשן הוא אמת> יקרה <מה שנמצא בסטאג'> י
                expression { // היטוי הבוליאני שצריך להתקיים כדי שהסטאג' יתבצע
                     //התנאי הבוליאני פה אומר אם הבראנצ הוא "דאב" וגם יש שינוי בקוד 
                     // בנוסף חשוב לשים לב שיש משתנים קבועים ויש כאלה שנצטרך להגדיר בעצמנו
                     // המשתנה בראנצ ניים הוא קבוע. המשתנה קוד צאנגס הוא לא ונצטרך להגדיר אותו בראש הקובץ
                     //כאן כתבתי אותו בגרשיים כי הוא לא מוגדר ולכן הגוב נכשל
                    env.BRANCH_NAME == 'dev' "&& CODE_CHANGES == true"
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