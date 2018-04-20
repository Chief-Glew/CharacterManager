pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'sh \'mvn -Dmaven.test.failure.ignore=true install\''
      }
    }
  }
  environment {
    Linux = ''
  }
}