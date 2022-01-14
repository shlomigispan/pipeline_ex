/*
הסבר על ההערות
תמיד ההערה תדבר על שורת הקוד שנמצאת תחתיה

*/
// הגדרת משתנה לטובת משיכת סקריפט מקובץ נוסף
//הקובץ מוגדר בהמשך ובמקרה פה זה בסטאג איניט. למיטב הבנתי אנחנו חייבים להגדיר את ערך המשתנה בתוך סטאג
def gv

// כאן נגדיר את המשתנים הלא מובנים מראש. נצטרך לקשר אותם לסקריפטים בשפת גרובי ששם נכתוב את הפעולות
// כתבתי בהערה כי הגוב יכשל בלי
// CODE_CHANGES == getGitChanges()
pipeline {
    // בחירת מכונה שעליה ירוצו הפעולות שבגנקינספייל
    agent any
    // יש לנו אפשרות להוסיף כל מיני פרמטרים ומשתנים למתי ואיך ירוץ הקוד
    // כדי להשתמש בזה בקוד חייבים לכתוב פאראמואז נקודה ואת שם המשתנה כמו שעשיתי בשלב הטסטינג ובשלב הפוסט בשני אופנים שונים
    parameters {
        // כאן ניתן להוסיף סטריג שיכנס למשתנה ברגע ההרצה, דומה קצת לאינפוט בפייתון
        string(name: 'VERSION', defaultValue: '', description: 'someting')
        // כאן ניתן לבחור ערך מתוך רשימה שיכנס למשתנה
        choice(name: 'VERSION2', choices: ['1.1', '1.2', '1.3'], description: 'someting2')
        // כאן ניתן לבחור ערכים של חיובי ושלילי
        booleanParam(name: 'VERSION3', defaultValue: true, description: 'someting3')
    }
    //כאן נוכל להגדיר כלים נוספים שנרצה לעבוד איתם לדוגמה מאייבן, גרידל וג'יי די קיי (גאווה) י
    //הכלים שנרצה לעבוד איתם חייבים להיות מותקנים בגנקינס בדלובל טוולס קונפיגוריישן
    tools {
        // לא ממש ברור לי איך בדיוק מכניסים את הכלי שרוצים להשתמש בו
        maven 'Maven'
    }
    // כאן נגדיר משתנים לקובץ
    environment {
        // דוגמה למשתנה
        NEW_VERSION = '1.3.0' 
        // קדנטיאלס זו פונקציה שמושכת את הקרדנשיאלס מהגנקיס (כמובן אחרי שהגדרנו אותם ) ומכניסה אותם למשתני סביבה
        // כדי לעבוד עם הפונקציה הזו נהייה חייבים להתקין פלאגין שנקרא Credentials Binding
        // הפרמטר שהפונקציה מקבלת זה המזהה של הקרדנשיאלס
        SERVER_CRENTIALS = credentials('github')
    }
    stages {
        // זה סטאג שבו אני מגדיר את ערך המשתנה 
        stage("init") {
            steps {
                // ככה אנחנו קוראים לסקריפטים ממקומות אחרים
                script {
                    // הגדרת ערך המששתנה כולל הנתיב ושם הקובץ שבו נמצאת הפונקציה
                   gv = load "script.groovy" 
                }
            }
        }
        stage("call_to_scripts") {
            steps {
                script {
                    // שלושת הפונקציות האלו נמצאות בקובץ שהגדרנו בסטאג איניט למעלה
                    gv.buildApp()
                    gv.testApp()
                    gv.deployApp()
                }
            }
        }
        stage("build") {
            when { // דוגמה לתנאי בוליאני: כלומר רק אם <הביטוי באקספרשן הוא אמת> יקרה <מה שנמצא בסטאג'> י
                expression { // היטוי הבוליאני שצריך להתקיים כדי שהסטאג' יתבצע
                     //התנאי הבוליאני פה אומר אם הבראנצ הוא "דאב" וגם יש שינוי בקוד 
                     // בנוסף חשוב לשים לב שיש משתנים קבועים ויש כאלה שנצטרך להגדיר בעצמנו
                     // המשתנה בראנצ ניים הוא קבוע. המשתנה קוד צאנגס הוא לא ונצטרך להגדיר אותו בראש הקובץ
                     //כאן כתבתי אותו בהערה כי הוא לא מוגדר ולכן הגוב נכשל
                    env.BRANCH_NAME == 'main' //&& CODE_CHANGES == true
                }
            }
            steps {
                echo "building the app..."
                // דוגמה לקריאה למשתנה. חשוב לשים לב שהמשתנה חייב להיות בגרשיים כפולות
                echo "app versin ${NEW_VERSION}"
                // דוגמה למשתנה בגרשים לא כפולות, בצורה זו הקובץ לא יקרא למשתנה
                echo 'app versin ${NEW_VERSION}'
            }
        }
        stage("test") {
            when {
                expression {
                    // הגדרה שהבלוק הזה ירוץ רק במצב שסימנו חיובי בהרצת הגוב
                    params.VERSION3 == true
                }
            }
            steps {
                echo "testing the app..."
                // כאן זה דוגמה להגדרת משתני סביבבה ברמת הבלוק בלבד
               // גם כאן כדי לעבוד עם הפונקציה הזו נהייה חייבים להתקין פלאגין שנקרא Credentials Binding
                withCredentials([
                    // אנחנו יכולים להישתמש במילים יוזרניימפאסוורד פה כי זה סוג הקרדנשיאל שהגדרנו
                    // ההגדרות בתוך הסוגריים הם: מאיזה איידי אנחנו רוצים לקחתת איך נקרא למשתנה שיאכסן את השם משתמש, איך נקרא למשתנה שיאכסן את הסיסמה
                    usernamePassword(credentialsId: 'github', usernameVariable: USER, passwordVariable: PWD)
                ]) {
                    // כאן זה הבלוק שמושפע מהמשתני סביבה הפנימיים בתוך הבלוק שהגדרנו
                    echo "some script ${USER} ${PWD}"
                }
            }
        }
        stage("deploy") {
            
            steps {
                script {
                    
                }
                echo "deploying the app..." 
                echo "deploying th ${SERVER_CRENTIALS}" 

            }
        }
    }
    post { // כאן נגדיר מה קורה בסיום הפעולה
        // תמיד לא משנה אם הצליח או לא
        always { 
            echo "pass ${params.VERSION2}"
        }
        // פעולות שיקרו רק אם הגוב הצליח
        success { 
            echo "pass"
        }
        // פעולות שיקרו רק אם הגוב נכשל
        failure { 
            echo "pass"
        }
    }
}