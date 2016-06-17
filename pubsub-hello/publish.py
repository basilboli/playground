import base64
from client import *

client = create_pubsub_client()

# You need to base64-encode your message.
message1 = base64.b64encode('Hello Cloud Pub/Sub!')
message2 = base64.b64encode('We are on the same boat.')

# Create a POST body for the Pub/Sub request
body = {
    'messages': [
        {'data': message1},
        {'data': message2},
    ]
}

resp = client.projects().topics().publish(
    topic='projects/single-object-747/topics/mytopic', body=body).execute()

message_ids = resp.get('messageIds')
if message_ids:
    for message_id in message_ids:
        # Process each message ID
        print message_id