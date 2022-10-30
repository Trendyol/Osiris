# Osiris SDK

Osiris, lord of the dead and rebirth

## Introduction

**Osiris SDK** is developed to intercept, manipulate and dispatch application analytics events. Its main purpose is to establish a bridge between the application and the analytics service.

## Motivation

Mobile applications work with more than one analytics service in some cases. In this case, some of the events may need to be routed to different analytics services. In addition to that, there could be requirement of some manipulations on event parameters for each analytics service. In this case, letting the events through a middleware before going to the event service allows us to enable these features.
