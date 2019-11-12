package com.example.gradlekotlinmailchimppoc

import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController()
@RequestMapping("api")
class MailChimpController(private val mailChimpService: MailChimpService) {

    @PostMapping("/subscribe")
    fun subscribe(@RequestBody mailChimp: MailChimp){
        mailChimpService.subscribe(mailChimp)
    }

    @PatchMapping("/unsubscribe")
    fun unsubscribe(@PathParam(value = "email") email:String){
        mailChimpService.unsubscribe(email)
    }

    @PatchMapping("/resubscribe")
    fun resubscribe(@PathParam(value = "email") email:String ){
        mailChimpService.resubscribe(email)
    }

    @DeleteMapping("/delete")
    fun delete(@PathParam(value = "email") email:String){
        mailChimpService.delete(email)
    }

    @PutMapping("/update")
    fun updateInfo(@RequestBody mailChimp: MailChimp){
        mailChimpService.updateInfo(mailChimp)
    }
}