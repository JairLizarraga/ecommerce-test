pipeline {
	agent any

	environment {
		mavenHome = tool 'maven-auto'
	}

	tools {
		jdk 'java-21'
        maven 'maven-auto'
	}

	stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('Deploy') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
	}
}