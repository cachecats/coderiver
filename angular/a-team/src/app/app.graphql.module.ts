// import { NgModule, Inject, PLATFORM_ID } from '@angular/core';
// import { isPlatformBrowser } from '@angular/common';
// import { ApolloModule, Apollo } from 'apollo-angular';
// import { HttpLinkModule, HttpLink } from 'apollo-angular-link-http';
// import { InMemoryCache } from 'apollo-cache-inmemory';
// import { WebSocketLink } from 'apollo-link-ws';
// import { split, ApolloLink } from 'apollo-link';
// import { getMainDefinition } from 'apollo-utilities';

// @NgModule({
//   imports: [
//     ApolloModule,
//     HttpLinkModule
//   ]
// })
// export class GraphqlModule {
//   constructor(
//     private readonly apollo: Apollo,
//     private readonly httpLink: HttpLink,
//     @Inject(PLATFORM_ID) private platformId: Object
//   ) {
//     if (isPlatformBrowser(platformId)) {
//       // Create an http link:
//       const http = httpLink.create({
//         uri: 'http://localhost:1337/graphql'
//       });

//       const authToken: string = localStorage.getItem('token') || null;
//       // Create a WebSocket link:
//       const ws = <any> new WebSocketLink({
//         uri:
//           'ws://localhost:1338/subscriptions',
//         options: {
//           reconnect: true,
//           connectionParams: {
//             authToken
//           }
//         }
//       });

//       // using the ability to split links, you can send data to each link
//       // depending on what kind of operation is being sent
//       const link = split(
//         // split based on operation type
//         ({ query }) => {
//           const { kind, operation } = getMainDefinition(query as any) as any;
//           return kind === 'OperationDefinition' && operation === 'subscription';
//         },
//         ws,
//         http,
//       );

//       apollo.create({
//         link,
//         cache: new InMemoryCache()
//       });
//     }
//   }
// }
