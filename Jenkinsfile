pipeline{
    agent any

    parameters{
        string(name: 'name_image', defaultValue: 'demo', description: 'name of docker container')
        string(name: 'name_container', defaultValue: 'demo', description: 'name of docker image')
        string(name: 'tag_version', defaultValue: 'v1', description: 'version of docker')
        string(name: 'port_image', defaultValue: '3001', description: 'port of docker image')
    }

    stages{
        stage('Gradle build'){
            steps{
                sh "gradle build"
            }
        }

        stage('Create docker image'){
            steps{
                sh "docker build -t ${name_image}:${tag_version} ."
            }
        }

        stage('Run docker image'){
            steps{
                sh "docker run -p ${port_image}:${port_image} --name=${name_container} ${name_image}:${tag_version}"
            }
        }
    }
}