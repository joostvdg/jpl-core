/**
 * Inspired by https://github.com/github/hub/issues/1644
 * @param username
 * @param repo
 * @param credentialsId
 * @return
 */
def call(username, repo, credentialsId) {
    withCredentials([string(credentialsId: credentialsId, variable: 'TOKEN')]) {
        sh "git remote set-url origin https://${env.TOKEN}:x-oauth-basic@github.com/${username}/${repo}.git"
    }
}