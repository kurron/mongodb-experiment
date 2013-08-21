package org.kurron.domain

import org.joda.time.DateTime
import org.kurron.RandomDataGenerator

/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/13/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
class NodeInformationBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()
    DateTime now = new DateTime()

    NodeInformation build(){
        NodeInformation node = new NodeInformation()
        node.id = generator.randomObjectId()
        node.instance = generator.randomInstance()
        node.nodeType = generator.randomNodeType()
        node.name = generator.randomHexString()
        node.nickname = generator.randomHexString()
        node.status = generator.randomNodeStatus()
        node.startDate = generator.randomDate(generator.randomNumberInclusive( 120 ))
        node.expirationDate = generator.randomDate( generator.randomNumberInclusive( 60 ) )
        node.tl = generator.randomHexString()
        node.partnerCustomer = generator.randomHexString()
        node.value = generator.randomLong()
        node.salesRep = generator.randomHexString()
        node.consortium = generator.randomHexString()
        node
    }
}

