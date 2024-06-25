def call(String build_status = 'STARTED') {
  build_status = build_status ?: 'SUCCESS'

  def color

  if (build_status == 'SUCCESS') {
    color = '#47ec05'
  } else if (build_status == 'UNSTABLE') {
    color = '#d5ee0d'
  } else {
    color = '#ec2805'
  }

  def msg = "${build_status}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

  slackSend(color: color, message: msg)
}
