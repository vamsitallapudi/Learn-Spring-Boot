#!/bin/bash

# Function to make request and extract status code
make_request() {
    response=$(curl -s -w "\n%{http_code}" http://localhost:8080/api/v1/posts)
    status_code=$(echo "$response" | tail -n1)
    body=$(echo "$response" | sed '$d')
    echo "Status Code: $status_code"
    if [ "$status_code" = "429" ]; then
        echo "Rate limit exceeded!"
    fi
}

echo "Making 25 requests rapidly..."
for i in {1..25}; do
    echo "Request $i:"
    make_request
    echo "-------------------"
    sleep 0.1  # Small delay to make output readable
done 