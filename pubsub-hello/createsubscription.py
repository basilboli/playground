from client import *
client = create_pubsub_client()

# Only needed if you are using push delivery
# push_endpoint = 'https://someproject.appspot.com/myhandler'

# Create a POST body for the Pub/Sub request
body = {
    # The name of the topic from which this subscription receives messages
    'topic': 'projects/single-object-747/topics/mytopic',
    # Only needed if you are using push delivery
    # 'pushConfig': {
    #     'pushEndpoint': push_endpoint
    # }
}

subscription = client.projects().subscriptions().create(
    name='projects/single-object-747/subscriptions/mysubscription',
    body=body).execute()

print 'Created: %s' % subscription.get('name')