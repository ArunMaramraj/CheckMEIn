import firebase_admin
from firebase_admin import credentials, storage 
from flask import Flask, jsonify
import base64
import webbrowser
from flask_ngrok import run_with_ngrok
creds = firebase_admin.credentials.Certificate("serviceAccountKey.json")

# initialize firebase admin
firebase_admin.initialize_app(creds, {
    'storageBucket': ' '   #enter your firebase storage link here
})
bucket_name = ' '         #enter your firebase storage link here
bucket = storage.bucket(bucket_name)

app = Flask(__name__)


@app.route('/')
def get_images():
    # Retrieve the list of images in the Firebase Storage bucket
    return "hi"


@app.route('/<pre>')
def get_images2(pre):
     # Retrieve the list of images in the variable <pre> folder of the Firebase Storage bucket
    blobs = bucket.list_blobs(prefix=pre)

    # Create a list of dictionaries containing the base64-encoded images and their file names
    image_list = []
    for blob in blobs:
        # Check if the blob is an image file (e.g., by checking the file extension)
        if blob.name.lower().endswith(('.png', '.jpg', '.jpeg', '.bmp', '.gif')):
            # Read the image data and encode it as a base64 string
            image_bytes = blob.download_as_bytes()
            image_base64 = base64.b64encode(image_bytes).decode('utf-8')

            # Add the base64-encoded image and its file name to the list
            image_list.append({'name': blob.name, 'image': image_base64})

    # Return the list of images as a JSON response to the android app
    return jsonify({'images': image_list})



if __name__=="__main__":
    app.run()