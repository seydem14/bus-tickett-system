from service.TripService import search_trips

def test_search_trips():
    result = search_trips(
        "Ankara",
        "İstanbul",
        "2026-06-10"
    )

    assert isinstance(result, list)