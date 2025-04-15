package com.example.demo

import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.assertThrows

class CesarTest {

    @Test
    fun `cesar retourne le bon caractere avec decalage simple`() {
        val result = cesar('A', 1)
        assertEquals('B', result)
    }

    @Test
    fun `cesar retourne A pour A avec decalage 26`() {
        val result = cesar('A', 26) // 26 % 26 = 0 → A
        assertEquals('A', result)
    }

    @Test
    fun `cesar retourne D pour A avec decalage 29`() {
        val result = cesar('A', 29) // 29 % 26 = 3 → D
        assertEquals('D', result)
    }

    @Test
    fun `cesar boucle correctement apres Z`() {
        val result = cesar('Z', 1)
        assertEquals('A', result)
    }

    @Test
    fun `cesar retourne C pour Y avec decalage 4`() {
        val result = cesar('Y', 4) // Y (24) + 4 = 28 → 2 → C
        assertEquals('C', result)
    }

    @Test
    fun `cesar retourne la meme lettre pour decalage multiple de 26`() {
        val result = cesar('M', 52) // 52 % 26 = 0
        assertEquals('M', result)
    }

    @Test
    fun `cesar lance une erreur si le decalage est negatif`() {
        assertThrows<IllegalStateException> {
            cesar('A', -1)
        }
    }

    @Test
    fun `cesar lance une erreur si le caractere n'est pas une majuscule`() {
        assertThrows<IllegalStateException> {
            cesar('a', 3)
        }
    }
}
