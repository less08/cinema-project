# Get all stages

Get list of all existing stages

**URL** : `/stages`

**Method** : `GET`

**Auth required** : YES

**Allowed for roles** : USER, ADMIN

**Query params**:   
   
    email: string - required
    
**Query params example**:

    email=sample
## Success Response

**Code** : `200 OK`

**Content example**:

```json
[
    {
        "id": 1,
        "capacity": 546,
        "description": "The Biggest concert hall in Europe"
    }
]
```