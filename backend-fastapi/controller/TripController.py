from fastapi import APIRouter
from service.TripService import search_trips

router = APIRouter()

@router.get("/api/trips")
def get_trips(fromCity: str, toCity: str, date: str):
    return search_trips(fromCity, toCity, date)