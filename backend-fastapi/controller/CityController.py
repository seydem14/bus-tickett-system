from fastapi import APIRouter
from service.CityService import get_cities

router = APIRouter()

@router.get("/api/cities")
def get_all_cities():
    return get_cities()