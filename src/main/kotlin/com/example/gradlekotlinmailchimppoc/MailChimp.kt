package com.example.gradlekotlinmailchimppoc

class MailChimp(val email:String?, val firstName:String?, val lastName:String?) {
    constructor() : this(null,null,null)
}