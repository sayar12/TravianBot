import React from 'react'
import {Header} from './Header'
import {mount} from 'enzyme'

describe('test header', () => {
  it('should display the header', () => {
    // When
    const component = mount(<Header/>)

    // Then
    expect(component.find('#header').length).toEqual(1)
  })
})