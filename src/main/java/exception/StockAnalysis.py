import yfinance as yf

# Fetch stock information for SBI (ticker: "SBIN.NS")
ticker = yf.Ticker("SBIN.NS")

# Get the latest market data
data = ticker.info

# Display specific information
print(f"Company Name: {data['address1']}")
print(f"Last Price: {data['industry']}")
