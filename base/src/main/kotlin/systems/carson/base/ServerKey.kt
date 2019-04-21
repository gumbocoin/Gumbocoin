package systems.carson.base

import java.security.PrivateKey
import java.security.PublicKey

object ServerKey {
    private val string = """
--- BEGIN PRIVATE KEY ---
MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/DepvbuZRXvEBOJpOGX2owOkTH1TW
Cj8gb4WnKg1hHABtggL3TAk+XftXfElM/ln36+JdckQHs3hwQCLi/+jUY0hSl8p1oKdEs+z4jlqm3OOg
J7iEmQAI9rR82lhorIjthYlo+idF3uzbxNFck38F7i/Ot65gpt7iMkbcZ1vZ5lJp+7yE36E9dbvu7sP/
OAPw/MYs9es7kETQj/9flDJx6aCR5kHkujVuhSO1+L5HcnsHbA82b5McNDKYiV2UvjBiSzGdppCjkfA/
tC1ggBVWZtJ7zav+EBooL45znnh1WJhwEjm96qBN5RPjWoGcQmmMlDCBoI7DhGCL4aIA3IppAgMBAAEC
ggEBALebIf9xLnpoqWgpA3Gm4bI5okQ0Sg1gz4XWZzVdHnqCtI6I8VzDf+al3xQWZ0NM9R1jXam8VFCq
U0Zc/Kn2kcT6nNhy86jTeax21XeRJuFRSpfxVExp1TTIEnAiTfBaT0Ukngd60B8/u5UAsssrHFmQq/UX
ZMeR1oS/GIZb9lOScakIOZx7wFz+rQfLxO7dMU9rxugAO/wKKEK22O2mFP0PsbxYbIFAVMEoAtgmoaQq
qaqOOfTOO3h9qZwUnB5E6NFZpnkmnVHE+nwl6kPQKLQnyD4gCmFXMRID31T9YMG4+uLTepFw8fAfeoAB
SROk1iiAnZNeVp6qGuXK2OYPg/kCgYEA5WumoX2aBKEMDqD2LFzG4saK6LEI1Or+wP+grT+q9w94uQH0
HztFENBwHgjKO0CyjvHhAD/ceChfQPA2kBMhaHIPcGi+gYC5sOqUnNW/YiirKYUsvQvMTUUc2Org4c+7
QcyH9Gop2XXV07fb/iX2gjcJhmQmtLF0jVAGBIy9TScCgYEA1TBeaTio+QvabiujQ5+rV8J9rPxMq+75
uzz8Ls0BGNaljgi46OV7ImJP9atSfB8QLvu/1PLAynYVRVE3j4ZfPNx2Bru+LM54LJkXPyT0sV9msN2O
hLkkVpexvtKLLf5vvRn1T9WpTUQPThbhD4rjbTXTengmjxsr/KDwTzi6Re8CgYBmjs4pqQ1d/mR2caw6
vqrGG71jMijhjb+epWe9qxWRZmAwTFhGUeeZEaTdOE63WD+6ORS9WM8FA/8492lc1MB9gWe3d4uaNuJL
3UHcLo1kowuI/xi11f1ZmYjAy5cGOyfZzUYFlCPrK4sQH0QABBaDtXjTlBfddOrGdTyLciL5xwKBgE8I
p3eKsdniMxA0zUn8n6DhUYYX4rS624o2iacwCQAUUzvcr/BnYsbUe6Av61xoh69jVTK07BQiwq/39AkZ
X6VIddj5MP+ba6Hc/2lBYhV/sKpQ+MzrdjVD93kuxLpAYVxRi0gVhbZHTQU+JiGE89tA4S297U2QXTZC
09QKy8OxAoGBAKGOPvgp6tJjHc0JkDLzjf5dj/ldvC5XLA6YmAV9ZfiV6VZVRJfy62RQZNA2e5X9z3wi
/UZck5FRwmDQBvNYfFJ6Hj0iZ+kkizaZWMKTLPHC9f714AINNK2c1+n/QgNUVqOJZJI4iVhOO2bq37S9
fueAPv7epauTTdbNiT1qpQqZ
--- END PRIVATE KEY ---
--- BEGIN PUBLIC KEY ---
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvw3qb27mUV7xATiaThl9qMDpEx9U1go/IG+F
pyoNYRwAbYIC90wJPl37V3xJTP5Z9+viXXJEB7N4cEAi4v/o1GNIUpfKdaCnRLPs+I5aptzjoCe4hJkA
CPa0fNpYaKyI7YWJaPonRd7s28TRXJN/Be4vzreuYKbe4jJG3Gdb2eZSafu8hN+hPXW77u7D/zgD8PzG
LPXrO5BE0I//X5QycemgkeZB5Lo1boUjtfi+R3J7B2wPNm+THDQymIldlL4wYksxnaaQo5HwP7QtYIAV
VmbSe82r/hAaKC+Oc554dViYcBI5veqgTeUT41qBnEJpjJQwgaCOw4Rgi+GiANyKaQIDAQAB
--- END PUBLIC KEY ---
    """.trimIndent()
    private val person = Person.deserialize(string)

    fun publicKey():PublicKey{
        return person.publicKey
    }
    private const val password = "6Lu+ji1ljuucZBctWAeJX3ld0kceqCSai6PlBwWxz"
    fun person(password :String): Person {
        if(this.password != password) {
            //TODO remove private key from client-side generation.
            error("Can't get private key without password\nTHE CLIENT CAN NOT ACCESS THE PRIVATE KEY")
        }
        return person
    }

}