from client import *
import base64

client = create_pubsub_client()

# You can fetch multiple messages with a single API call.
batch_size = 100

subscription = 'projects/single-object-747/subscriptions/mysubscription'

# Create a POST body for the Pub/Sub request
body = {
    # Setting ReturnImmediately to false instructs the API to wait
    # to collect the message up to the size of MaxEvents, or until
    # the timeout.
    'returnImmediately': False,
    'maxMessages': batch_size,
}
while True:

    resp = client.projects().subscriptions().pull(
        subscription=subscription, body=body).execute()

    received_messages = resp.get('receivedMessages')
    if received_messages is not None:
        ack_ids = []
        for received_message in received_messages:
            pubsub_message = received_message.get('message')
            if pubsub_message:
                # Process messages
                print base64.b64decode(str(pubsub_message.get('data')))
                # Get the message's ack ID
                ack_ids.append(received_message.get('ackId'))

        # Create a POST body for the acknowledge request
        ack_body = {'ackIds': ack_ids}

        # Acknowledge the message.
        client.projects().subscriptions().acknowledge(
            subscription=subscription, body=ack_body).execute()