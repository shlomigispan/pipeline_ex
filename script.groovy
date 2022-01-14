
def buildApp() {
    echo 'building the application...'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

// לשים לב שאת השורה הזו אנחנו שמים פעם אחת בסוף הקובץ
// אני לא בטוח שזה הכרחי אבל לפחות אני יודע שבצורה הזו זה בטוח עובד
return this
