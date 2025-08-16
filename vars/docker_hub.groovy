  def call(String ProjectName, string tag) {
    stage('DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubpass')]) {
                    sh '''
                        docker login -u "$dockerHubUser" -p "$dockerHubpass"
                        docker push "$dockerHubUser"/${ProjectName}:${tag}"
                    '''
                }
            }
        }
        
  }