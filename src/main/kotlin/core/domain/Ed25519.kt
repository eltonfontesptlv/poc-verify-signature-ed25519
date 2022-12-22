package br.com.petlove.core.domain

import org.bouncycastle.asn1.edec.EdECObjectIdentifiers
import org.bouncycastle.asn1.x509.AlgorithmIdentifier
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.KeyFactory
import java.security.Signature
import java.security.spec.X509EncodedKeySpec
import java.util.*

data class Ed25519(
    val algorithm: String = "ed25519"
)

fun Ed25519.verifySignature(credential: Credential, message: Message): Boolean {
    val provider = BouncyCastleProvider()
    val byteKey = Base64.getDecoder().decode(credential.publicKey)
    val info = SubjectPublicKeyInfo(AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), byteKey)
    val spec = X509EncodedKeySpec(info.encoded)
    val kf = KeyFactory.getInstance(algorithm, provider)
    val publicKeyGeneration = kf.generatePublic(spec)
    return Signature.getInstance(algorithm, provider).apply {
        initVerify(publicKeyGeneration)
        update(message.build().toByteArray())
    }.verify(Base64.getDecoder().decode(credential.signature))
}