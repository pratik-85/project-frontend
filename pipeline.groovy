pipeline{
    agent any
    stages{
        stage("Code-Pull"){
            steps{
                git branch: 'dev', url: 'https://github.com/pratik-85/project-frontend.git'
            }
        }
        stage("Code-Build"){
            steps{
                sh '''npm install
                   ng build '''
            }
        }
        stage("Code-Deploy"){
            steps{
                sh 'aws s3 cp --recursive dist/angular-frontend s3://frontend-cbz-07-05-2025/'
            }
        }
    }
}
