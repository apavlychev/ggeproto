package ru.ggeproto.inf.common
package utils

object UuidHelper {
    def randomUuid: String = java.util.UUID.randomUUID.toString.replaceAll("-", "")
}
