const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const connectDB = require('./config/db');
const deviceRoutes = require('./routes/deviceRoutes');
const { default: mongoose } = require('mongoose');

const app = express();

// Connect Database
connectDB();

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Routes
app.use('/api/devices', deviceRoutes);

const PORT = process.env.PORT || 5001;
mongoose.connect('mongodb+srv://temp:temp@cluster0.wkea2ju.mongodb.net/') 
const { MongoClient } = require('mongodb');
    
const uri = "mongodb+srv://temp:temp@cluster0.wkea2ju.mongodb.net/"; 
const client = new MongoClient(uri);

async function connectToDatabase() {
    try {
        await client.connect();
        console.log("Connected to MongoDB Atlas");
    } catch (error) {
        console.error("Connection failed", error);
    }
};

connectToDatabase();

app.listen(PORT, () => {
    console.log((`Server is running on port ${PORT}`));
});
