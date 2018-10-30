/**
 * Inspired by https://github.com/github/hub/issues/1644
 * @param url
 * @param credentialsId
 * @return
 */
def call(String url, credentialsId) {
    assert url: 'Url is not set (first param)'
    assert credentialsId: 'credentialsId is not set (second param)'
    assert url.contains('https://'): 'Url is not a https url, this only works with "https://....git" kind of urls'

    withCredentials([string(credentialsId: credentialsId, variable: 'TOKEN')]) {
        def alteredUrl = url.replace("https://", "https://${env.TOKEN}:x-oauth-basic@")
        sh "git remote set-url origin ${alteredUrl}"
    }
}