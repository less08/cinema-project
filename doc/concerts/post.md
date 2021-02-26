# Add new concert

Adding a new concert to database

**URL** : `/concerts`

**Method** : `POST`

**Auth required** : YES

**Allowed for roles** : ADMIN

**Data example** :

```json
{
    "title": "Mozart's night",
    "description": "Mozart's music, like Haydn's, stands as an archetype .."
}
```

## Success Responses
**Code** : `200 OK`

**Content example** : 

```json
{}
```