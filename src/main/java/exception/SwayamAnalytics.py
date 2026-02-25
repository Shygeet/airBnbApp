
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split


df = pd.read_csv(r"C:\Users\shivanshut.sw\Desktop\Swayam Py Course\Tips (1) (1).csv")

# Calculate 3rd quartile (75th percentile)
q3 = df['TotalBill'].quantile(0.75)

# Calculate maximum value
max_val = df['TotalBill'].max()

print("3rd Quartile (Q3):", q3)
print("Maximum Value:", max_val)

df['TotalBill'] = pd.to_numeric(df['TotalBill'], errors='coerce')

# Drop rows where TotalBill is NaN
total_bill_clean = df['TotalBill'].dropna()

# Create the box plot
plt.figure(figsize=(10, 6))
sns.boxplot(y=total_bill_clean, color='lightblue', width=0.4)

# Customize
plt.title('Box Plot of Total Bill', fontsize=16, fontweight='bold')
plt.ylabel('Total Bill ($)', fontsize=12)
plt.grid(True, axis='y', alpha=0.3)

# Add some statistics as text
q1 = total_bill_clean.quantile(0.25)
q2 = total_bill_clean.median()
q3 = total_bill_clean.quantile(0.75)
iqr = q3 - q1
lower_whisker = max(total_bill_clean.min(), q1 - 1.5*iqr)
upper_whisker = min(total_bill_clean.max(), q3 + 1.5*iqr)

plt.text(0.02, 0.95, f'Median: ${q2:.2f}\nQ1: ${q1:.2f}\nQ3: ${q3:.2f}\nIQR: ${iqr:.2f}',
         transform=plt.gca().transAxes, fontsize=11, verticalalignment='top',
         bbox=dict(boxstyle="round", facecolor="wheat", alpha=0.8))

plt.tight_layout()
plt.show()


