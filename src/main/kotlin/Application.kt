package br.com.petlove

import br.com.petlove.core.domain.Credential
import br.com.petlove.core.domain.Ed25519
import br.com.petlove.core.domain.Message
import br.com.petlove.core.domain.verifySignature

fun main(args: Array<String>) {
    val message = Message(
        method = "POST",
        path = "/5601829c-cad6-4187-85e1-233ab71f79c9",
        timestamp = "2022-12-01T14:32:52.085Z",
        payload = "{\"referenceId\":\"PAY-18FPVYYIRRDEIEKG\",\"pspReferenceId\":\"cd7a9893-269c-49fb-95e4-6441e748bd6e\",\"timestamp\":\"2022-12-01T14:32:51.997Z\",\"code\":\"CANCELLED_BY_SELLER\",\"message\":\"Seller has cancelled this payment.\",\"paymentMethodType\":\"nupay\"}"
    )
    val credential = Credential(
        publicKey = "6WFNWA1YiXUP4pYCUAjzr77m0L5iaOwz6OhmvIyFABg=",
        signature = "zvQto61cNnSIEaLLX32r6Abm6ZOwcvLy2wXTZvcNNWgPdIBNR2HmKtZGt0jCpEQcqqEH0iZEz6wNmPQ82AFMBQ=="
    )

    val verified = Ed25519().verifySignature(credential, message)
    println(verified)
}


