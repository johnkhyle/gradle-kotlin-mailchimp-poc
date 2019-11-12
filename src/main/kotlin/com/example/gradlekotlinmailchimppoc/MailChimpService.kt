package com.example.gradlekotlinmailchimppoc

import com.ecwid.maleorang.MailchimpClient
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.method.v3_0.lists.members.DeleteMemberMethod
import com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod
import org.springframework.stereotype.Service
import java.util.*

@Service
class MailChimpService (){
    val apiKey:String = "" // place your api key here
    val listId:String ="" // place your audience id here

    fun subscribe(mailChimp: MailChimp){
        MailchimpClient(apiKey).use { client ->
            client.execute(EditMemberMethod.Create(listId, mailChimp.email.toString()).apply {
                status = "subscribed"
                merge_fields = MailchimpObject().apply {
                    mapping["FNAME"] = mailChimp.firstName
                    mapping["LNAME"] = mailChimp.lastName
                }
                timestamp_signup = Date(0)
            })}
    }

    fun unsubscribe(email: String){
        MailchimpClient(apiKey).use { client ->
            client.execute(EditMemberMethod.Update(listId, email).apply {
                status = "unsubscribed"
                timestamp_signup = Date(10000)
            })
        }
    }

    fun resubscribe(email:String){
        MailchimpClient(apiKey).use{client ->
            client.execute(EditMemberMethod.Update(listId, email).apply {
                status = "subscribed"
                timestamp_signup = Date(10000)
            })
        }
    }
    fun updateInfo(mailChimp: MailChimp){
        MailchimpClient(apiKey).use { client ->
            client.execute(EditMemberMethod.Update(listId, mailChimp.email.toString()).apply {
                merge_fields = MailchimpObject().apply {
                    if(!mailChimp.firstName.isNullOrBlank()){
                        mapping["FNAME"] = mailChimp.firstName
                    }
                    if(!mailChimp.lastName.isNullOrBlank()){
                        mapping["LNAME"] = mailChimp.lastName
                    }
                }
                timestamp_signup = Date(10000)
            })
        }
    }

    fun delete(email: String){
        MailchimpClient(apiKey).use { client ->
            client.execute(DeleteMemberMethod(listId, email))

        }
    }
}