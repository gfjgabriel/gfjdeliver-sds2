import React from 'react';
import { StyleSheet, ScrollView, Text, View } from 'react-native';
import Header from '../header';
import OrderCard from '../orderCard';


function Orders() {


  return (
      <>
        <Header />
        <ScrollView style={styles.container}>
          <OrderCard />
          <OrderCard />
          <OrderCard />
          <OrderCard />
          <OrderCard />
        </ScrollView>
    </>
  );
}

const styles = StyleSheet.create({
    container: {
      paddingRight: '5%',
      paddingLeft: '5%'
    }
});

export default Orders;