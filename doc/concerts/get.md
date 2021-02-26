# Get all concerts

Get list of all existing stages

**URL** : `/concerts`

**Method** : `GET`

**Auth required** : YES

**Allowed for roles** : USER, ADMIN

## Success Response

**Code** : `200 OK`

**Content example**:

```json
[
    {
        "id": 1,
        "title": "Mozart's night",
        "description": "Mozart's music, like Haydn's, stands as an archetype .."
    }
]
```