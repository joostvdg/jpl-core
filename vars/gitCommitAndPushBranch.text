def call(String branchName, String change) {
    assert branchName: 'I need tagName to be valid'
    def createTagCommand = """
    git commit -m "update ${branchName} for "
    git push origin ${branchName}
    """
    if (isUnix()) {
        sh createTagCommand
    } else {
        bat createTagCommand
    }
}
