pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "back-end"  // Nome da imagem Docker
        DOCKER_TAG = "latest"  // Tag para a imagem Docker
        DOCKERFILE_PATH = "/var/lib/jenkins/workspace/back-end/Dockerfile"  // Caminho para o Dockerfile
    }

    stages {
        stage('Stop Docker Containers') {
            steps {
                sh '''
                    CONTAINERS=$(docker ps -aq)
                    if [ -n "$CONTAINERS" ]; then
                        docker stop $CONTAINERS
                        docker rm -f $CONTAINERS
                    else
                        echo "Nenhum contêiner para parar ou remover."
                    fi
                '''
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    sh "cd /var/lib/jenkins/workspace/back-end"
                    sh "docker rmi ${DOCKER_IMAGE}:${DOCKER_TAG} || true"
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} -f ${DOCKERFILE_PATH} ."
                }
            }
        }

        stage('Deploy and Restart Containers') {
            steps {
                script {
                    // Itera pelos hosts e sobe novos contêineres com a nova imagem
                    sh """
                    docker run -p 8090:8090 -d --name back-end --restart always \
                    -v /var/log:/var/log \
                    ${DOCKER_IMAGE}:${DOCKER_TAG} > /var/log/backend.log 2>&1
                    """
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline concluído!'
        }
    }
}