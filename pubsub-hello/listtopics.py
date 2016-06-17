from client import * 

client = create_pubsub_client()

next_page_token = None
while True:
    resp = client.projects().topics().list(
        project='projects/single-object-747',
        pageToken=next_page_token).execute()
    # Process each topic
    for topic in resp['topics']:
        print topic['name']
    next_page_token = resp.get('nextPageToken')
    if not next_page_token:
        break