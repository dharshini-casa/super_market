package model
case class Admin(username: String, password: String) {
    def checkPassword(password: String) = true
}
