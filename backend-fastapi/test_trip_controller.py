from fastapi.testclient import TestClient
from main import app

client = TestClient(app)


def test_get_trips():
    response = client.get(
        "/api/trips",
        params={
            "fromCity": "Ankara",
            "toCity": "İstanbul",
            "date": "2026-06-10"
        }
    )

    assert response.status_code == 200
    assert isinstance(response.json(), list)