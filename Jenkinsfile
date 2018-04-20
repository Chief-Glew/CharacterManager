pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('deploy') {
      steps {
        sh 'java -jar target/dndcharacter-1.0-SNAPSHOT.war'
      }
    }
  }
  environment {
    Linux = ''
  }
}